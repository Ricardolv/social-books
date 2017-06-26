$(function() {
    $('.js-load-books').on('click', function() {
        $.ajax({
            url: 'http://localhost:8080/books',
            type: 'get',
            headers: {
                'Authorization' : 'Basic cmljaGFyZDpzZW5oYQ=='
            },
            success: function(response) {
                createTable(response);
            }
        });
    })
});

function createTable(data) {
    $('.js-books-table-body tr').remove();
    for(var i=0; i < data.length; i++) {
        createLine(data[i]);
    }
}

function createLine(line) {
    var lineTable = $('<tr/>');
    $('.js-books-table-body').append(lineTable);
    lineTable.append('<td>' + line.id + '</td>');
    lineTable.append('<td>' + line.name + '<td>');
    lineTable.append('<td>' + line.publishers + '<td>');
    lineTable.append('<td>' + line.publication + '<td>');
    lineTable.append('<td>' + line.resume + '<td>');
}