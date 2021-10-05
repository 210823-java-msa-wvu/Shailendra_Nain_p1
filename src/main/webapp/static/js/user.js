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

//function populateData(data) {
//
//    // This is where we will do our DOM manipulation
//    let dataSection = document.getElementById('data');
//
//    // Create a new element
//    let nameTag = document.createElement('h3');
//
//    // Add text to the inner html of the new element
//    // <h3>innerHtml</h3>
//
//    // Append this new element to the section element (adding it as a child node in the DOM)
//    dataSection.appendChild(nameTag);
//
//
//    // Now we'll use the same process for the Abilities
//    let usersArray = data;
//    console.log(usersArray);
//
//    /**
//     * <ul>
//     *    <li>"Ability Name"</li>
//     *    <li>"Ability Name"</li>
//     *    <li>"Ability Name"</li>
//     * </ul>
//     */
//
//    // Create an unordered list element
//    let eachUsr = document.createElement('ul');
//    dataSection.innerHTML += 'ID<br>';
//    dataSection.appendChild(eachUsr);
//
//    // Iterate over the abilities array and create 'li' elements
//    for (let usr of usersArray) { // for-of -> iterate over the elements inside the array
//        let users = document.createElement('li');
//        let email = usr.email;
//        getInfo(email);
//        users.innerHTML = email + usr.password;
//        eachUsr.appendChild(users);
//    }
//
//     TODO - add sprites to the rendered page and capitalize words.
//    let spritesObject = res.sprites;
//    console.log(spritesObject);
//
//    for (let sprite in spritesObject) {// for-in loop -> iterate over the indexes of the array (0...1....2...n)
//
//        if (typeof spritesObject[sprite] == 'string') {
//            let spriteImg = document.createElement('img');
//            //spriteImg.setAttribute('src', spritesObject[sprite]);
//            spriteImg.src = spritesObject[sprite];
//            dataSection.appendChild(spriteImg);
//        }
//
//    }
//}
