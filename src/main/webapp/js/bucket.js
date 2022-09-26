const BUCKET_ENDPOINT = 'bucket';
const createBucketCard = (product) => `<div class="bucket-item">
        <div class="image">
            <img width="150px" height="150px" src="${product.image}"
                 alt="product">
        </div>

        <div class="content">
            <h3>${product.name}</h3>
            <p>
                ${product.description}
            </p>
        </div>
        <div class="buttons">
            <button onclick="removeItem(${product.id})" class="btn btn-danger">Remove</button>
        </div>

    </div>`

function getProducts(){
    fetch(BUCKET_ENDPOINT,
        {
            method: 'GET',
            headers:{
                'Content-Type':'application/json'
            }
        }).then((responce) =>
        responce.json())
          .then((json) =>{
           console.log(json)
              displayItems(json)
    })
}

function displayItems(items) {
    const bucket = document.getElementById('bucket');
    for (const item of items){
        bucket.innerHTML += createBucketCard(item)
    }
}

function removeItem(id) {
    console.log('START', id)
    fetch(`${BUCKET_ENDPOINT}?productId=${id}`,{
        method: 'DELETE'
    }).then(() => {
        window.location.reload()
    })
}
getProducts()