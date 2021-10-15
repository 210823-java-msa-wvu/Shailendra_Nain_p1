async function addForm(){
    let url = 'http://localhost:8080/home/application';
    let userurl = 'http://localhost:8080/home/user';

    let eventType = document.getElementById("eventType").value;
    let description = document.getElementById("description").value;
    let fees = document.getElementById("fees").value;
    fees = reimbursementCoverage(eventType, fees);
    console.log(fees);
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
function reimbursementCoverage(eventType, fees){
    if(eventType === "UniversityCourses"){
        amount = (fees  * 80)/100;
        return amount;
    }else if(eventType === "Seminars"){
        amount = (fees  * 60)/100;
        return amount;
    }else if(eventType === "CertificationPrep"){
         amount = (fees  * 75)/100;
           return amount;
    }else if(eventType === "Certification"){
          amount = (fees  * 100)/100;
            return amount;
    }else if(eventType === "TechnicalTraining"){
       amount = (fees  * 90)/100;
        return amount;
    }else if(eventType === "Other"){
        amount = (fees  * 30)/100;
            return amount;
    }
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
            let appno = document.createElement('td');
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
            row.appendChild(appno);
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
            appno.innerHTML = dat.id;
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

        let appid = document.getElementById('approvalId').valueAsNumber;
        let status = document.getElementById('appStatusUpdate').value;
        let res = await fetch(url)
        let data = await res.json()

        let resp = await fetch(appurl)
        let appdata = await resp.json()
        console.log(appid, status);
        var appform;
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
                indexArray[12] =dat.user.id;
                }
        }
        let event = indexArray[1];
        let desc = indexArray[2];
        let fee = indexArray[3];
        let gr = indexArray[4];
        let date = indexArray[5];
        let time = indexArray[6];
        let loc = indexArray[7];
        let just  = indexArray[8];
        let sup = indexArray[9];
        let man = indexArray[10];
        let ben = indexArray[11];
        let userid = indexArray[12];

         if(data.jobTitle === 'supervisor'){
               appform = {
               "id": appid,
                "eventype": event,
               "description": desc,
               "fees": fee,
               "grade": gr,
               "appdate": date,
               "apptime": time,
               "applocation": loc,
               "appjustification": just,
               "supervisor": status,
               "manager": man,
               "benco": ben,
               "user": {
                   "id": userid
                       }
                 }
               } else if(data.jobTitle === 'manager'){
             appform = {
                 "id": appid,
                  "eventype": event,
                 "description": desc,
                 "fees": fee,
                 "grade": gr,
                 "appdate": date,
                 "apptime": time,
                 "applocation": loc,
                 "appjustification": just,
                 "supervisor": sup,
                 "manager": status,
                 "benco": ben,
                 "user": {
                     "id": userid

                         }
            }
                 }else if(data.jobTitle == 'benco'){
                            appform = {
                             "id": appid,
                             "eventype": event,
                            "description": desc,
                            "fees": fee,
                            "grade": gr,
                            "appdate": date,
                            "apptime": time,
                            "applocation": loc,
                            "appjustification": just,
                            "supervisor": sup,
                            "manager": man,
                            "benco": status,
                            "user": {
                                "id": userid

                                    }
                            }
                    }

    console.log(appform);
    let response = await fetch(`${appurl}/${appid}`, {
            method: 'PUT',
            body: JSON.stringify(appform),
            headers: {
                'Content-Type': 'application/json'
            }
        })
//        let resJson = await response.
        .then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        });
}

async function userAccount(){
    let url = 'http://localhost:8080/home/user';
    let appUrl = 'http://localhost:8080/home/application';
    let acUrl = 'http://localhost:8080/home/account';
    let balance = document.getElementById('showBalance');
    let userUrl = await fetch(url)
    let userData = await userUrl.json()


    let appRes = await fetch(appUrl)
    let appData = await appRes.json()

    let acRes = await fetch(acUrl)
    let acData = await acRes.json()

    console.log(userData.id);
    console.log(acData);
    let userArray = [];

    let accountForm, id, userid, amount, awarded, pending ;
    console.log(appData);
    for(const ac of acData){
       if(ac.user.id == userData.id){
            userArray[0]=ac.id;
            userArray[1] = ac.user.id;
            userArray[2] = ac.amount;
            userArray[3] = ac.awarded;
            userArray[4] = ac.pending;
       }
    }
    id = userArray[0];
    userid = userArray[1];
    amount = userArray[2];
    awarded = userArray[3];
    pending = userArray[4];
    balance.innerHTML = `Current Balance:$${amount-pending}`;
    for(app of appData){
        if(userid == app.user.id){
            pending += app.fees;
        }
    }
        accountForm = {
                    "user" : {
                        "id" : userData.id
                    },
                    "amount": 1000,
                    "awarded": 0,
                    "pending": pending
                }
                console.log(accountForm);
               let response = await fetch(`${acUrl}/${id}`, {
               method: 'PUT',
               body: JSON.stringify(accountForm),
               headers: {
                   'Content-Type': 'application/json'
               }
           })
   //        let resJson = await response.
           .then((response) => {
               console.log(response);
           }).catch((error) => {
               console.log(error);
           });


    console.log(accountForm);
    console.log(userArray.amount);
}

async function cancelRequest(){
 let url = 'http://localhost:8080/home/application';
   let userInput = document.getElementById('cancelNumber').valueAsNumber;


     let response = await fetch(`${url}/${userInput}`, {
                 method: 'DELETE'
             })
     //        let resJson = await response.
             .then(() => {
                 alert("Request Canceled");
             }).catch((error) => {
                 console.log(error);
             });
}