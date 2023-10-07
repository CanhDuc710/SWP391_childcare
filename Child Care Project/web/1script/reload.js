document.addEventListener('keydown', function (event) {
    // Kiểm tra nếu người dùng nhấn F5 hoặc Ctrl+R hoặc Command+R
    if (event.key === 'F5' || (event.ctrlKey && event.key === 'r') || (event.metaKey && event.key === 'r')) {
        // Ngăn chặn gửi lại request bằng cách hủy sự kiện
        event.preventDefault();

        // Reload/refresh lại trang hoặc thực hiện các hành động khác tùy ý
        window.location.reload(true); // True để bỏ qua bộ nhớ cache và tải lại từ máy chủ
    }
});