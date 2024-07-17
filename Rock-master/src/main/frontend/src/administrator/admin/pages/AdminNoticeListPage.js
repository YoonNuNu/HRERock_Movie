import {useEffect, useRef, useState} from 'react';
import axios from 'axios';
import {Link, useNavigate} from 'react-router-dom';


// css
import "../../../common/css/AdminNoticeListPage.css"

function AdminNoitceListPage() {

    const [isLoading, setIsLoading] = useState(true);
    const [hasPermission, setHasPermission] = useState(false);
    const navigate = useNavigate();
    const initializedRef = useRef(false);

    const checkPermission = async () => {
        const token = localStorage.getItem('accessToken');
        if (!token) {
            alert("로그인이 필요합니다.");
            navigate('/login');
            return;
        }

        try {
            const response = await axios.get('/auth/memberinfo', {
                headers: { 'Authorization': 'Bearer ' + token }
            });
            const role = response.data.memRole;
            if (role === 'ADMIN') {
                setHasPermission(true);
            } else {
                alert("권한이 없습니다.");
                navigate('/');
            }
        } catch (error) {
            console.error('Error fetching user info:', error);
            alert("오류가 발생했습니다. 다시 로그인해주세요.");
            navigate('/login');
        } finally {
            setIsLoading(false);
        }
    };

    useEffect(() => {
        if (!initializedRef.current) {
            initializedRef.current = true;
            checkPermission();
        }
    }, []);

    // if (isLoading) {
    //     return <div>Loading...</div>;
    // }

    if (!hasPermission) {
        return null; // 또는 권한 없음 메시지를 표시할 수 있습니다.
    }



    return (
        <>

        <div className="admin_notice_div">
            {/* <!-- 공지사항 제목 --> */}
            <div className="admin_notice_haed">
                <h2>공지사항</h2>
            </div>
            <div className="notice_link">
                <span><Link to="/user/Notice" className='black'>자세히 보러 가기 {'>'}</Link></span>
            </div>

            <div className="admin_notice_list_menu">
                <ul className="admin_notice_list_ul">
                    <li>번호</li>
                    <li>제목</li>
                    <li>날짜</li>
                </ul>
            </div>
            {/* <!-- 공지사항 리스트 --> */}
            <div className="admin_notice_list">
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
                <ul className="admin_notice_list_ul">
                    <li>10</li>
                    <li><Link to="/user/Notive/View" className='black'>공지사항 1</Link></li>
                    <li>2024.06.26</li>
                </ul>
            </div>
            <div className="admin_notice_page">
                <ul className="admin_notice_page_ul">
                    <li>&lt;</li>
                    <li>1</li>
                    <li>2</li>
                    <li>3</li>
                    <li>4</li>
                    <li>5</li>
                    <li>6</li>
                    <li>7</li>
                    <li>8</li>
                    <li>9</li>
                    <li>10</li>
                    <li>&gt;</li>
                </ul>

            </div>
        </div>

        </>





    );

}











export default AdminNoitceListPage;