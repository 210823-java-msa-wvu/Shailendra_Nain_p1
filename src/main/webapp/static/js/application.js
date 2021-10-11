async function addForm(){
    let url = 'http://localhost:8080/home/application';
    let userurl = 'http://localhost:8080/home/user';

    let eventType = document.getElementById("eventType").value;
    let description = document.getElementById("description").value;
    let fees = document.getElementById("fees").value;
    let grade = document.getElementById("grade").value;
    let appdate = document.getElementById("appdate").value;
    let apptime = document.getElementById("apptime").value;
    let applocation = document.getElementById("applocation").value;
    let appjustification = document.getElementById("appjustification").value;
    let newForm;
    let userres = await fetch(userurl)
    let userdata = await userres.json()
        .then(userdata => {
                newForm ={
                "eventype" : eventType,
                "description" : description,
                "fees" : fees,
                "grade" : grade,
                "appdate" : appdate,
                "apptime" : apptime,
                "applocation" : applocation,
                "appjustification" : appjustification,
                "supervisor": "pending",
                "manager": "pending",
                "benco": "pending",
               "user": {
                           "id":userdata.id}
            }
        })
        .catch(err => console.log(err));



    console.log(newForm);

    let res = await fetch(url, {
        method: 'POST',
        body: JSON.stringify(newForm),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    let resJson = await res.json()
    .then((res) => {
        console.log(newForm);
        reset();
    }).catch((error) => {
        console.log(error);
    });

}
function reset(){
    document.getElementById("eventType").value ='Event Type';
    document.getElementById("description").value ='';
    document.getElementById("fees").value ='';
    document.getElementById("grade").value ='';
    document.getElementById("appdate").value ='';
    document.getElementById("apptime").value ='';
    document.getElementById("applocation").value ='';
    document.getElementById("appjustification").value ='';
}

async function getUser() {

    let url = 'http://localhost:8080/home/user';

    console.log(localStorage);
    let res = await fetch(url)
    let data = await res.json()

    .then(data => {
//        console.log(data);
       populateData(data);
    })
    .catch(err => console.log(err));

}
function populateData(data){
    let firstname = document.getElementById('firstname');
    let lastname = document.getElementById('lastname');
    let welcome = document.getElementById('welcome');
    firstname.value = data.firstName;
    lastname.value = data.lastName;
    welcome.innerHTML = `Welcome ${data.firstName}  ${data.lastName}`;
}

async function getUserApplication() {
    let url = 'http://localhost:8080/home/user';
    let appurl = 'http://localhost:8080/home/application';
    let res = await fetch(url)
    let data = await res.json()
    let resp = await fetch(appurl)
    let appdata = await resp.json()

    .then(appdata => {
       showAllUserRequest(appdata, data);
           })
    .catch(err => console.log(err));


}
function showAllUserRequest(appdata, data){
        let showdata = document.getElementById('showdata');
        let btnHide = document.getElementById('hideButton');
        let count =1;
       if(appdata != null){
        for(dat of appdata){
        console.log(dat);
        let row = document.createElement('tr');
            showdata.appendChild(row);
         if(dat.user.id === data.id){
            let id = document.createElement('td');
            let eventype = document.createElement('td');
            let description = document.createElement('td');
            let fees = document.createElement('td');
            let grade = document.createElement('td');
            let appdate = document.createElement('td');
            let apptime = document.createElement('td');
            let applocation = document.createElement('td');
            let appjustification = document.createElement('td');
            let status = document.createElement('td');
            id.setAttribute("scope","col");
            row.appendChild(id);
            row.appendChild(eventype);
            row.appendChild(description);
            row.appendChild(fees);
            row.appendChild(grade);
            row.appendChild(appdate);
            row.appendChild(apptime);
            row.appendChild(applocation);
            row.appendChild(appjustification);
            row.appendChild(status);
            id.innerHTML = count++;
            eventype.innerHTML = dat.eventype;
            description.innerHTML = dat.description;
            fees.innerHTML = `$${dat.fees}`;
            grade.innerHTML = dat.grade;
            appdate.innerHTML = dat.appdate;
            apptime.innerHTML = dat.apptime;
            applocation.innerHTML = dat.applocation;
            appjustification.innerHTML = dat.appjustification;
            if(dat.supervisor == "pending" && dat.manager == "pending" && dat.benco == "pending"){
                status.innerHTML = "Application Pending";
            }else if(dat.supervisor != "pending" || dat.manager != "pending" || dat.benco != "pending"){
                status.innerHTML = "In Process";
            }else if(dat.supervisor == "approve" && dat.manager == "approve" && dat.benco == "approve"){
                status.innerHTML = "Application Approved";
            }else if(dat.supervisor == "reject" && dat.manager == "reject" && dat.benco == "reject"){
                status.innerHTML = "Application Rejected"
            }
            hideButton.style.display ='none';
//            <button type="button" onclick="getUserApplication()" class="btn btn-primary">Check Details</button>
         }
        }
    }
}
async function getAllApplication() {
    let url = 'http://localhost:8080/home/user';
    let appurl = 'http://localhost:8080/home/application';
    let res = await fetch(url)
    let data = await res.json()
    let resp = await fetch(appurl)
    let appdata = await resp.json()

    .then(appdata => {
       showAllApplications(appdata, data);
           })
    .catch(err => console.log(err));

}

function showAllApplications(appdata, data){
        let showdata = document.getElementById('showdata');
        let count =1;
       if(appdata != null){
            for(dat of appdata){
                    let row = document.createElement('tr');
                        showdata.appendChild(row);
                        let countid = document.createElement('td');
                        let id = document.createElement('td');
                        let eventype = document.createElement('td');
                        let description = document.createElement('td');
                        let fees = document.createElement('td');
                        let grade = document.createElement('td');
                        let appdate = document.createElement('td');
                        let apptime = document.createElement('td');
                        let applocation = document.createElement('td');
                        let appjustification = document.createElement('td');
                        let supervisor = document.createElement('td');
                        let manager = document.createElement('td');
                        let benco = document.createElement('td');
                        let employeeName = document.createElement('td');
                        row.appendChild(countid);
                        row.appendChild(employeeName);
                        row.appendChild(id);
                        row.appendChild(eventype);
                        row.appendChild(description);
                        row.appendChild(fees);
                        row.appendChild(grade);
                        row.appendChild(appdate);
                        row.appendChild(apptime);
                        row.appendChild(applocation);
                        row.appendChild(appjustification);
                        row.appendChild(supervisor);
                        row.appendChild(manager);
                        row.appendChild(benco);
                        countid.innerHTML = count++;
                        employeeName.innerHTML = `${dat.user.firstName} ${dat.user.lastName}`;
                        id.innerHTML = dat.id;
                        eventype.innerHTML = dat.eventype;
                        description.innerHTML = dat.description;
                        fees.innerHTML = `$${dat.fees}`;
                        grade.innerHTML = dat.grade;
                        appdate.innerHTML = dat.appdate;
                        apptime.innerHTML = dat.apptime;
                        applocation.innerHTML = dat.applocation;
                        appjustification.innerHTML = dat.appjustification;
                        supervisor.innerHTML = dat.supervisor;
                        manager.innerHTML = dat.manager;
                        benco.innerHTML = dat.benco;
            //            <button type="button" onclick="getUserApplication()" class="btn btn-primary">Check Details</button>

       }

    }
}



function showForm(){
    let applicationForm = document.getElementById('applicationForm');
    let buttonHide = document.getElementById('btn-hide');
    applicationForm.classList.toggle('displayForm');
    buttonHide.style.display = 'none';


}
function idDropDown(){
    let appid = document.getElementById('applicationId');
        for(dat of appdata){
            let option = document.createElement('option');
                appid.appendChild(option);
                option.setAttribute('value', dat.id);
                option.innerHTML = dat.id;
        }
}
async function approval(){
    let url = 'http://localhost:8080/home/user';
        let appurl = 'http://localhost:8080/home/application';
        let appid = document.getElementById('approvalId').value;
        let status = document.getElementById('appStatusUpdate').value;
        let res = await fetch(url)
        let data = await res.json()
        let resp = await fetch(appurl)
        let appdata = await resp.json()
        console.log(appid, status);
        let appform;
        let indexArray = [];

        for(dat of appdata){
            if(appid == dat.id){
                indexArray[0] =dat.id;
                indexArray[1] =dat.eventype;
                indexArray[2]  =dat.description;
                indexArray[3] =dat.fees;
                indexArray[4] =dat.grade;
                indexArray[5] =dat.appdate;
                indexArray[6] =dat.apptime;
                indexArray[7] =dat.applocation;
                indexArray[8] =dat.appjustification;
                indexArray[9] =dat.supervisor;
                indexArray[10] =dat.manager;
                indexArray[11] =dat.benco;
                }
        }

         if(data.jobTitle == "supervisor"){
                appform = {
                      "id": parseInt(appid),
                     "eventype": indexArray[1],
                     "description": indexArray[2],
                     "fees": indexArray[3],
                     "grade": indexArray[4],
                      "appdate": indexArray[5],
                       "apptime": indexArray[6],
                       "applocation": indexArray[7],
                       "appjustification": indexArray[8],
                        "supervisor": status,
                        "manager": indexArray[10],
                        "benco": indexArray[11],
                        "user": {
                         "id" : data.id
                         }
                }


                 }
                else if(data.jobTitle == "manager"){
             appform = {
            "id": parseInt(appid),
            "eventype": indexArray[1],
             "description": indexArray[2],
             "fees": indexArray[3],
             "grade": indexArray[4],
              "appdate": indexArray[5],
               "apptime": indexArray[6],
               "applocation": indexArray[7],
               "appjustification": indexArray[8],
                "supervisor": indexArray[9],
                "manager": status,
                "benco": indexArray[11],
            "user": {
                "id" : data.id
            }                                 }
                 }else if(data.jobTitle == "benco"){
                            appform = {
                            "id": parseInt(appid),
                            "eventype": indexArray[1],
                              "description": indexArray[2],
                              "fees": indexArray[3],
                              "grade": indexArray[4],
                               "appdate": indexArray[5],
                                "apptime": indexArray[6],
                                "applocation": indexArray[7],
                                "appjustification": indexArray[8],
                                 "supervisor": indexArray[9],
                                 "manager": indexArray[10],
                                 "benco": status,
                 "user": {
                     "id" : data.id
                             }


     }
}

    console.log(appform);
    let respp = await fetch(appurl, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(appform)
        });

        let resJson = await respp.json()
        .then(resJson => {
            console.log(appform);
        })
        .catch(error => {
            console.log(error);
        });

}

