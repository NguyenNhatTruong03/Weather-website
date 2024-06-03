// Tạo một đối tượng XMLHttpRequest
var xhttp = new XMLHttpRequest();
xhttp.open("GET", "Mapreduce", true);

// Xác định hàm callback xử lý khi nhận được phản hồi từ server
xhttp.onreadystatechange = function() {
	if (this.readyState === 4 && this.status === 200) {
		// Lấy dữ liệu chuỗi từ phản hồi
		var temperature = this.responseText;
		temperature = temperature.replace(/"/g, '');
		console.log("Nhiet do trung binh: " + temperature);

		// Hiển thị giá trị nhiệt độ trong phần tử HTML
		document.getElementById("temperature").innerHTML = temperature + "\u2103";
	}
};

// Gửi Ajax request đến URL để lấy dữ liệu nhiệt độ
xhttp.send();