function start(){
    var xhttp;
    if (window.XMLHttpRequest){
        // ��� ��� IE7+, Firefox, Chrome, Opera, Safari
        xhttp = new XMLHttpRequest();
    } else {
        // ��� ��� IE6, IE5
        xhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState == 4 && xhttp.status == 200)
            document.getElementById('textfield').innerHTML = xhttp.responseText;
    }
    xhttp.open('POST', 'txt/Formula.txt', true);
    xhttp.send();
}