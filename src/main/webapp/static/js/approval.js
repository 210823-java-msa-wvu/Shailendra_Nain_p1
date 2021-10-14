//function addBook() {
//
//    // Collect user input...
//    let bookTitle = document.getElementById('bookTitle').value;
//    let authorFirst = document.getElementById('authorF').value;
//    let authorLast = document.getElementById('authorL').value;
//
//    // and save into an object
//    let data = {
//        title: bookTitle,
//        author: {
//            firstName: authorFirst,
//            lastName: authorLast
//        }
//    }
//
//    console.log(data);
//
//    // Now we can prepare and send our XMLHttpRequest Object
//    let xhttp = new XMLHttpRequest();
//
//    xhttp.onreadystatechange = function () {
//
//        if (this.readyState == 4 && this.status == 200) {
//
//            let r = this.responseText;
//            console.log(r);
//
//        }
//
//    }
//
//    xhttp.open('POST', 'http://localhost:8080/LibraryServlet/books', true);
//
//    // because we are sending data in the body, we need to tell our server what to expect
//    xhttp.setRequestHeader('Content-Type', 'application/json');
//
//    xhttp.send(JSON.stringify(data));
//
//
//}

function getApplications() {

    let url = 'http://localhost:8080/home/application';

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = receiveData;
    let count = 0;
    function receiveData() {
        console.log(this.readyState);

        if (this.readyState == 4) {
            let r = this.responseText;

            r = JSON.parse(r);
            const tableRow = document.getElementById("populateData")
                        tableRow.innerHTML = "";
                        r.forEach(res => {

                            const content = `
                                    <option value=${res.id}>${res.id}</option>
                            `
                            tableRow.innerHTML += content;
                            count += 1;
                        })
                    }

        }

    xhttp.open('GET', url, true);

    xhttp.send();

}

function alertMessage(){
    const select = document.getElementById("populateData").value;

    alert(`You have selected: ${select}`);
}

