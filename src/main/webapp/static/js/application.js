async function getApp(){
    let url = "localhost:8080/home/static/application.html";

     let user = {
            event: document.getElementById('eventType').value,
            description: document.getElementById('description').value
            description: document.getElementById('fees').value
            description: document.getElementById('date').value
            description: document.getElementById('time').value
            description: document.getElementById('location').value
            description: document.getElementById('justification').value
        }

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