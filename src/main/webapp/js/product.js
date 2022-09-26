const PRODUCT_ENDPOINT = 'product';
const BUCKET_ENDPOINT = 'bucket';
const userId = localStorage.getItem('userId')
const createCard = (product) => `

         <div class="col">
             <div class="card shadow-sm" style="max-height: 400px">
                <img src="${product.image}" alt="product" width="250" height="250" style="margin: 0 auto" >

                <div class="card-body">
                    <p class="card-text" >${product.name}</p>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                        <a href="product?id=${product.id}">
                            <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                        </a>
                            <button onclick="addProductToBucket(${product.id})" type="button" class="btn btn-sm btn-outline-success">
                                <i class="fa-sharp fa-solid fa-basket-shopping"></i>
                            </button>
                        </div>
                        <span class="text-muted">${product.price}</span>
                    </div>
                </div>
             </div>
         </div>
`


function saveProduct(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const productObject = {};

    formData.forEach((value, key) => {
        productObject[key] = value;
    });

    console.log(productObject);
    // productObject.image = null;


    const sendData = async (data) => {
        const response = await fetch(PRODUCT_ENDPOINT, {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                'Content-type': 'application/json'
            }
        });
        console.log(response);


        if (response.status !== 200){
            document.getElementById("alert").removeAttribute("hidden");
        } else {
            window.location.href = response.url;
        }
    }
    sendData(productObject);
}


function getAllProducts() {
   fetch(PRODUCT_ENDPOINT,{
       method:'GET',
       headers:{
           'Content-Type':'application/json'
       }
   }).then((response) =>{
       console.log(response);
       return response.json();
    }).then((json) => {
       console.log(json);
       displayCards(json)
   })
}



function displayCards(products) {
    const container = document.getElementById('cards');
    for (const product of products){
        container.innerHTML += createCard(product)

    }
}

function addProductToBucket(productId) {
    if (!userId){
        window.location.href = 'login.jsp';
        return;
    }
    fetch(BUCKET_ENDPOINT, {
            method:'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                bucketId: userId,
                productId:productId
            })
        }).then((result) => {
            alert('Added to bucket')
    })
}
getAllProducts();