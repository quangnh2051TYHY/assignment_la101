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
});
