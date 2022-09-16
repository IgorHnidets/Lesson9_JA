const REGISTRATION_ENDPOINT = 'registration';
function handleregister(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const userObj = {};

    formData.forEach((value,key)=>{
        userObj[key] = value;
    })

    const messageBlock = document.getElementById("message")


    if (userObj.password !== userObj.confirmation){
        messageBlock.innerText = 'Passwords should match'
        return
    }



    const sendData = async (data)=>{
        const responce = await fetch(REGISTRATION_ENDPOINT, {
            method:"POST",
            body:JSON.stringify(data),
            headers:{
                'Content-type':'application/json'
            }
        });
        console.log(responce);


        switch (responce.status){
            case 200:
                window.location.href = responce.url;
                break;
            case 409:
                messageBlock.innerText = `User with email ${userObj.email} is already exist`
                document.getElementById('email').style.outline = '1px solid red'
                break;
            default:
                messageBlock.innerText = 'Something went wrong. Please try again'
        }
    }
sendData(userObj)
}