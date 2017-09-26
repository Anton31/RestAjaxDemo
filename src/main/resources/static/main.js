function getAjax() {
    $("#update").hide()
    $.ajax({
        type: "GET",
        url: "/rest/person", success: function (result) {

            for (var i = 0; result.length > i; i++) {
                $("<tr>" +
                    "<td><button class='btn btn-danger' onclick='deleteAjax(" + result[i].id + ")'>Delete</button></td>" +
                    "<td>" + result[i].name + "</td>" +
                    "<td>" + result[i].age + "</td>" +
                    "<td>" + result[i].weight + "</td>" +
                    "<td>" + result[i].height + "</td>" +
                    "<td><button class='btn btn-info'  onclick='getByIdAjax(" + result[i].id + ")'>Update</button></td>" +
                    "</tr>").appendTo("#data");
            }
        }
    })
}

function deleteAjax(id) {
    $.ajax({
        type: "DELETE",
        url: "/rest/person/" + id,
        success: function () {
            $("#data").empty();
            getAjax()
        }
    })
}

function getByIdAjax(id) {
    $("#update").show()
    $("#personList").hide()
    $.ajax({
        type: "GET",
        url: "/rest/person/" + id,
        success: function (result) {
            $("#id").val(result.id)
            $("#updateName").val(result.name)
            $("#updateAge").val(result.age)
            $("#updateHeight").val(result.height)
            $("#updateWeight").val(result.weight)
        }
    })
}

function updateAjax() {
    var formData = {
        id: $("#id").val(),
        name: $("#updateName").val(),
        age: $("#updateAge").val(),
        height: $("#updateHeight").val(),
        weight: $("#updateWeight").val()
    }
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        url: "/rest/person",
        data: JSON.stringify(formData),
        success: function () {
            $("#personList").show()
            $("#update").hide()
            $("#data").empty()
            getAjax()
        }
    })
}

function ajaxPost() {
    var formData = {
        name: $("#name").val(),
        age: $("#age").val(),
        weight: $("#weight").val(),
        height: $("#height").val()
    }
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/rest/person",
        data: JSON.stringify(formData),
        success: function () {
            location.href = "/index.html"
        }
    })
}











