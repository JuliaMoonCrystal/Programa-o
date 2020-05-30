var xml=new XMLHttpRequest();

xml.open('GET','https://api.github.com/users/JuliaMoonCrystal');
xml.send('null');

xml.onreadystatechange=function(){
    if(xml.readyState === 4){
        console.log(JSON.parse(xml.responseText));
    }
}