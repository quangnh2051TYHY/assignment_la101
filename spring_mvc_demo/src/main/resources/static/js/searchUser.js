function appear() {
    document.getElementById("add").style.height = "100%";
}
function closeTab() {
    document.getElementById("add").style.height = "0%";
}

document.addEventListener("DOMContentLoaded", function () {
    const contentString = window.localStorage.getItem("contentArray");

    if (contentString) {
        const contentArray = JSON.parse(contentString);

        const tableBody = document.getElementById("dept-table");

        for (let i = 0; i < contentArray.length; i++) {
            const contentView = contentArray[i];

            const newRow = tableBody.insertRow(-1);

            const cell1 = newRow.insertCell(0);
            const checkbox = document.createElement("input");
            checkbox.type = "checkbox";
            checkbox.addEventListener("click", function () {
                if (checkbox.checked) {
                    selectedRows.push(contentView);
                } else {
                    const index = selectedRows.findIndex(
                        (item) =>
                            item.username === contentView.username &&
                            item.name === contentView.name &&
                            item.deptName.join(", ") === contentView.deptName.join(", ")
                    );
                    if (index !== -1) {
                        selectedRows.splice(index, 1);
                    }
                }
            });
            cell1.appendChild(checkbox);

            const cell2 = newRow.insertCell(1);
            cell2.textContent = contentView.state;

            const cell3 = newRow.insertCell(2);
            cell3.textContent = contentView.username;

            const cell4 = newRow.insertCell(3);
            cell4.textContent = contentView.name;

            const cell5 = newRow.insertCell(4);
            cell5.textContent = contentView.deptName.join(", ");
        }
    } else {
        console.log("No content found");
    }

    let selectedRows = [];

    document
        .querySelector(".first-row input[type='checkbox']")
        .addEventListener("click", function () {
            const checkboxes = document.querySelectorAll(
                "#dept-table input[type='checkbox']"
            );
            checkboxes.forEach(function (checkbox) {
                checkbox.checked = !checkbox.checked;
                if (checkbox.checked) {
                    const contentView = JSON.parse(
                        window.localStorage.getItem("contentArray")
                    ).find(
                        (item) =>
                            item.username ===
                            checkbox.parentNode.nextElementSibling.textContent &&
                            item.name ===
                            checkbox.parentNode.nextElementSibling.nextElementSibling
                                .textContent &&
                            item.deptName.join(", ") ===
                            checkbox.parentNode.nextElementSibling.nextElementSibling
                                .nextElementSibling.textContent
                    );
                    if (selectedRows.indexOf(contentView) === -1) {
                        selectedRows.push(contentView);
                    }
                } else {
                    const index = selectedRows.findIndex(
                        (item) =>
                            item.username ===
                            checkbox.parentNode.nextElementSibling.textContent &&
                            item.name ===
                            checkbox.parentNode.nextElementSibling.nextElementSibling
                                .textContent &&
                            item.deptName.join(", ") ===
                            checkbox.parentNode.nextElementSibling.nextElementSibling
                                .nextElementSibling.textContent
                    );
                    if (index !== -1) {
                        selectedRows.splice(index, 1);
                    }
                }
            });
        });

    document.querySelectorAll(".remove-btn").forEach(function (button) {
        button.addEventListener("click", function () {
            if (selectedRows.length > 0) {
                const table = document.getElementById("dept-table");
                selectedRows.forEach(function (selectedRow) {
                    for (let i = 0; i < table.rows.length; i++) {
                        if (
                            table.rows[i].cells[2].innerHTML === selectedRow.username &&
                            table.rows[i].cells[3].innerHTML === selectedRow.name &&
                            table.rows[i].cells[4].innerHTML ===
                            selectedRow.deptName.join(", ")
                        ) {
                            table.deleteRow(i);
                            break;
                        }
                    }
                    const contentString = window.localStorage.getItem("contentArray");
                    if (contentString) {
                        const contentArray = JSON.parse(contentString);
                        const index = contentArray.findIndex(
                            (item) =>
                                item.username === selectedRow.username &&
                                item.name === selectedRow.name &&
                                item.deptName.join(", ") === selectedRow.deptName.join(", ")
                        );
                        if (index !== -1) {
                            contentArray.splice(index, 1);
                            window.localStorage.setItem(
                                "contentArray",
                                JSON.stringify(contentArray)
                            );
                        }
                    }
                });
                selectedRows = [];
            } else {
                alert("Please select a row to remove.");
            }
        });
    });
});
