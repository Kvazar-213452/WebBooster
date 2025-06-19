function showResponse(htmlContent) {
    document.getElementById("page").innerHTML = htmlContent;
}

function load_page(page_name) {
    Android.sendMessage(JSON.stringify({type: "page", name: page_name}));
}
