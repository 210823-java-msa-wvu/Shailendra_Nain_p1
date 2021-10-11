async function login() {

    let url = "http://localhost:8080/home/login";
    console.log(userUrl);
    let user = {
        username: document.getElementById('email').value,
        password: document.getElementById('password').value
    }
//        localStorage.setItem("userLoginObj", JSON.stringify(user));
//        localStorage.setItem("email", JSON.stringify(document.getElementById('email').value));
//        let empJson = JSON.parse(userUrl);
//        localStorage.setItem("eid",empJson.id);
//        localStorage.setItem("empName", empJson.first_name + " " + empJson.last_name);

    console.log(user);

    let res = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(user)
    });

    let resJson = await res.json()
    .then(res => {
        console.log(res);

    })
    .catch(error => {
        console.log(error);
    });

}

async function getUser() {

    let url = 'http://localhost:8080/home/user';

    let res = await fetch(url)
    let data = await res.json()

    .then(data => {
        console.log(data);
       populateData(data);
    })
    .catch(err => console.log(err));

}
function populateData(data){
    let firstname = document.getElementById('firstname');
    let lastname = document.getElementById('lastname');
    firstname.value = data.firstName;
    lastname.value = data.lastName;
}