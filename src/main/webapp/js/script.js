function loadBooks() {
    var xmlhttp = new XMLHttpRequest();
    var url = "webapi/books";

    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var books = JSON.parse(this.responseText);
            addBooksToTable(books);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function addBooksToTable(books) {
    var out = "";
    var i;
    for (i = 0; i < books.length; i++) {
        out += '<tr>' + addTD(books[i].id) + addTD(books[i].name) + addTD(books[i].author) + '</tr>';
    }
    document.getElementById("books").innerHTML += out;
}

function addTD(content) {
    return '<td>' + content + '</td>';
}

loadBooks();

var form = document.getElementById("addbookform");

form.onsubmit = function(e) {
    // stop the regular form submission
    e.preventDefault();

    // collect the form data while iterating over the inputs
    var data = {};
    for (var i = 0, ii = form.length; i < ii; ++i) {
        var input = form[i];
        if (input.name) {
            data[input.name] = input.value;
        }
    }

    // construct an HTTP request
    var xhr = new XMLHttpRequest();
    xhr.open(form.method, form.action, true);
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    // send the collected data as JSON
    xhr.send(JSON.stringify(data));

    xhr.onloadend = function() {
        // done
    };
};
