$(document).ready(function () {

    $("#inscription").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var search = {}
    search["email"] = $("#input-email").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/inscription",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            $('#inscription').hide();
            $('#feedback').html("Inscrição feita com sucesso! :D");
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            $('#feedback').html(json);
            console.log("ERROR : ", e);
        }
    });

}