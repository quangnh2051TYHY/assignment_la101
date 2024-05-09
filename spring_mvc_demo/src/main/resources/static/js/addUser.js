var deptList = [];
document
    .getElementById("addButton")
    .addEventListener("click", function (event) {
        addDepartment(event);
    });

function addDepartment(event) {
    event.preventDefault();
    var input = document.getElementById("dept-input").value.trim();
    var list = document.getElementById("dept-list");
    if (input !== "") {
        deptList.push(input);
        list.value = deptList.join("\n");
        document.getElementById("dept-input").value = "";
    }
}

document
    .getElementById("deleteButton")
    .addEventListener("click", function (event) {
        deleteDepartment(event);
    });

function deleteDepartment(event) {
    event.preventDefault();
    var input = document.getElementById("dept-input").value.trim();
    var list = document.getElementById("dept-list");
    var index = deptList.indexOf(input);
    if (index !== -1) {
        deptList.splice(index, 1);
        list.value = deptList.join("\n");
        document.getElementById("dept-input").value = "";
    }
}

$(document).ready(function(){
    $('#addUserForm').submit(function(event) {
        // event.preventDefault();

        $.ajax({
            type: "POST",
            url: "/user/create",
            data: $(this).serialize(), // Lấy dữ liệu từ form
            success: function(response) {
                // Nếu có thông báo thành công từ server
                if (response && response.message) {
                    alert(response.message);
                    location.reload();
                }
            },
            error: function(xhr, status, error) {
                // Hiển thị thông báo lỗi từ server
                var errorMessage = xhr.responseJSON ? xhr.responseJSON.error : "Unknown error occurred";
                alert(errorMessage);
            }
        });
    });
});