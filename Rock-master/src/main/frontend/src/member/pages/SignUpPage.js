import React, { useState } from 'react';
import axios from 'axios';
import '../../common/css/SignUp.css';

function SignUp() {
    const [formData, setFormData] = useState({
        memId: '',
        memPassword: '',
        memPasswordCheck: '',
        memName: '',
        memEmail: '',
        memBirthdate: '',
        memGender: '남성',
        memPhoneNumber: '',
    });
    const [emailVerificationCode, setEmailVerificationCode] = useState('');
    const [isEmailVerified, setIsEmailVerified] = useState(false);
    const [isIdAvailable, setIsIdAvailable] = useState(false);
    const [agreeToTerms, setAgreeToTerms] = useState(false);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const checkIdAvailability = async () => {
        try {
            const response = await axios.get(`/auth/check-id?memId=${formData.memId}`);
            setIsIdAvailable(!response.data);
            alert(response.data ? "이미 사용 중인 아이디입니다." : "사용 가능한 아이디입니다.");
        } catch (error) {
            console.error("ID 중복 확인 중 오류 발생:", error);
            alert("ID 중복 확인 중 오류가 발생했습니다.");
        }
    };

    const sendVerificationEmail = async () => {
        try {
            // 이메일 중복 체크
            const response = await axios.get(`/auth/check-email?memEmail=${formData.memEmail}`);

            if (response.data) {
                // 이미 사용 중인 이메일인 경우
                alert("이미 사용 중인 이메일입니다.");
            } else {
                // 사용 가능한 이메일인 경우
                alert("사용 가능한 이메일입니다.");

                // 인증 메일 발송
                await axios.post('/auth/send-verification-email', { memEmail: formData.memEmail });
                alert("인증 이메일이 발송되었습니다. 이메일을 확인해주세요.");
            }
        } catch (error) {
            console.error("이메일 확인 또는 인증 메일 발송 중 오류 발생:", error);
            alert("처리 중 오류가 발생했습니다.");
        }
    };

    const verifyEmail = async () => {
        try {
            const response = await axios.post('/auth/verify-email', {
                email: formData.memEmail,
                verificationCode: emailVerificationCode
            });
            setIsEmailVerified(true);
            alert("이메일이 성공적으로 인증되었습니다.");
        } catch (error) {
            console.error("이메일 인증 중 오류 발생:", error);
            alert("이메일 인증에 실패했습니다.");
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!isIdAvailable) {
            alert("아이디 중복 확인을 해주세요.");
            return;
        }
        if (!isEmailVerified) {
            alert("이메일 인증을 완료해주세요.");
            return;
        }
        if (!agreeToTerms) {
            alert("이용약관에 동의해주세요.");
            return;
        }
        if (formData.memPassword !== formData.memPasswordCheck) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }
        try {
            const response = await axios.post('/auth/signup', formData);
            alert("회원가입이 완료되었습니다.");
            // 회원가입 후 로그인 페이지로 이동하거나 다른 작업 수행
        } catch (error) {
            console.error("회원가입 중 오류 발생:", error);
            alert("회원가입 중 오류가 발생했습니다.");
        }
    };

    return (
        <div className="wrap">
            <div className='signupheder'><h2>회원가입</h2></div>

            <form onSubmit={handleSubmit}>
                <div className="inner">
                    {/* 아이디 */}
                    <div className='idDiv'>
                        <div className='username2'>아이디<input type="text" name="memId" value={formData.memId} onChange={handleChange} className='commonpage'/></div>
                        <button type="button" onClick={checkIdAvailability} className='idbutton'>중복 확인</button>
                    </div>

                    {/* 비밀번호 */}
                    <div className='password2'>비밀번호  <input type="password" name="memPassword" value={formData.memPassword} onChange={handleChange} className='commonpage'/></div>
                    <div className='passwordcheck'>비밀번호 확인 <input type="password" name="memPasswordCheck" value={formData.memPasswordCheck} onChange={handleChange} className='commonpage'/></div>

                    {/* 이름 */}
                    <div className='name2'>이름  <input type="text" name="memName" value={formData.memName} onChange={handleChange} className='commonpage'/></div>

                    {/* 이메일 */}
                    <div className='emailDiv'>
                        <div className='email2'>이메일 <input type="email" 
                                                           name="memEmail" 
                                                           value={formData.memEmail} onChange={handleChange} className='commonpage'/>
                        </div>
                        
                        <button type="button" 
                                onClick={sendVerificationEmail} 
                                className='idbutton'>이메일<br/>인증
                        </button>
                    </div>
                    
                    {/* 이메일 받은 코드입력 */}
                    <div className='emailDiv'>
                        <div className='email2'>인증 코드 <input type="text" 
                                                             value={emailVerificationCode} 
                                                             onChange={(e) => setEmailVerificationCode(e.target.value)} 
                                                             className='commonpage'/>
                        </div>
                        <button type="button" 
                                onClick={verifyEmail} 
                                className='idbutton'>인증
                        </button>
                        
                    </div>

                    {/* 생년월일 */}
                    <div className='bu'>생년월일 <input type="date" 
                                                    name="memBirthdate" 
                                                    value={formData.memBirthdate} 
                                                    onChange={handleChange} 
                                                    className='commonpage'/>
                    </div>

                    {/* 성별 */}
                    <div className="gender">
                        <div id="mg">
                            <label htmlFor="gender">성별 선택</label>
                        </div>
                        <div className="asd">
                            <select id="gender"
                                    name="memGender"
                                    value={formData.memGender}
                                    onChange={handleChange}
                                    className="sel">
                                <option value="남성">남성</option>
                                <option value="여성">여성</option>
                            </select>
                        </div>
                    </div>

                    <div className='phonnumber'>휴대폰 번호<input type="tel"
                                                             name="memPhoneNumber"
                                                             value={formData.memPhoneNumber} onChange={handleChange} className='commonpage'/>
                    </div>
                </div>

                {/* 이용약관 */}
                <div className='textfile'>
                    <h3 className="title">이용약관</h3>
                    <div className="text">
                        {/* 이용약관 내용 */}
                    </div>
                    {/* 동의 버튼 */}
                    <label className="custom-checkbox">
                        <input type="checkbox"
                               required
                               onChange={(e) => setAgreeToTerms(e.target.checked)} />
                        <span className="checkmark">동의(필수)</span>
                    </label>
                </div>

                {/* 가입하기 버튼 */}
                <button type="submit"
                        className='signupsubmit'>회원가입</button>
            </form>
        </div>
    );
}

export default SignUp;