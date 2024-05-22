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