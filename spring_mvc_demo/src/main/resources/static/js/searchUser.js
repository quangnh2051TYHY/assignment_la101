function appear() {
    document.getElementById("add").style.height = "100%";
}
function closeTab() {
    document.getElementById("add").style.height = "0%";
}
function removeSelectedUsers() {
    var selectedUsers = [];
    $('.userCheckbox:checked').each(function () {
        selectedUsers.push($(this).val());
    });

    if (selectedUsers.length > 0) {
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/user/remove",
            data: JSON.stringify(selectedUsers),
            success: function () {
                alert("Remove successfully!")
                location.reload(); // Refresh page after successful removal
            },
            error: function (e) {
                alert("Remove failed!")
                console.log("Error: ", e);
            }
        });
    } else {
        alert("Please select at least one user to remove.");
    }
}