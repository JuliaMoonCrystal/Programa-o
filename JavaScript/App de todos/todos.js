 var linkElement = document.querySelector('#app ul');
 var inputElement=document.querySelector('#app input');
 var btnElement=document.querySelector('#app button');

 var todos=JSON.parse(localStorage.getItem('list_todos')) || [];
  

 function renderTodos(){
   linkElement.innerHTML='';

   for(todo of todos){
       var todoElement=document.createElement('li');
       var todoText=document.createTextNode(todo);


        var element=document.createElement('a');
        var elementtxt=document.createTextNode('Excluir');

        element.setAttribute('href','#');

        element.appendChild(elementtxt);

        var pos=todos.indexOf(todo);
        element.setAttribute('onclick','deleteTodos('+pos+')');

       todoElement.appendChild(todoText);
       todoElement.appendChild(element);
       linkElement.appendChild(todoElement);

   }
 }
 renderTodos();

 function addtodos(){
     var texTodo=inputElement.value;
     todos.push(texTodo);
     inputElement.value='';
     renderTodos();
     saveTodoStorage();
 }
 btnElement.onclick=addtodos;

 function deleteTodos(pos) {
     todos.splice(pos, 1);
     renderTodos();
     saveTodoStorage();
 }

 function saveTodoStorage(){
    //JSON
    localStorage.setItem('list_todos',JSON.stringify(todos));
    

 }
