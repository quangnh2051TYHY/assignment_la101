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

let content = JSON.parse(window.localStorage.getItem("contentArray")) || [];

document.addEventListener("DOMContentLoaded", function () {
    let state = null;
    let username = document.getElementById("login-name");
    let password = document.getElementById("password");
    let repassword = document.getElementById("repassword");
    let fname = document.getElementById("fname");
    let lname = document.getElementById("lname");
    let fnamekana = document.getElementById("fname-kana");
    let lnamekana = document.getElementById("lname-kana");
    let deptName = document.getElementById("dept-list");

    document
        .querySelector(".submit-btn")
        .addEventListener("click", function (event) {
            event.preventDefault();

            if (checkValidate()) {
                let user = {
                    state: "Effectiveness",
                    username: username.value,
                    name: fname.value + " " + lname.value,
                    deptName: deptName.value.split("\n"),
                };
                content.push(user);
                window.localStorage.setItem("contentArray", JSON.stringify(content));
                alert("User added successfully!");

                // reset form
                deptName.value = "";
                const inputs = document.querySelectorAll("input");
                inputs.forEach((input) => {
                    input.value = "";
                });
                const selects = document.querySelectorAll("select");
                selects.forEach((select) => {
                    select.selectedIndex = 0;
                });
            }
        });

    function checkValidate() {
        let isValid = true;

        if (password.value !== repassword.value) {
            alert("Password does not match!");
            isValid = false;
        }

        if (
            username.value === "" ||
            password.value === "" ||
            repassword.value === "" ||
            fname.value === "" ||
            lname.value === "" ||
            fnamekana.value === "" ||
            lnamekana.value === "" ||
            deptName.value === ""
        ) {
            alert("Please fill in require fields!");
            isValid = false;
        }
        return isValid;
    }
});
