
var modal=document.getElementById('Delete_Modal');
var add_modal=document.getElementById('ADD_Modal');
//DELETE button

var ADD_MODAL_BTN = document.getElementById('ADD_button')
var modalBtn=document.getElementById("DELETE_button");

var closeBtn=document.getElementById("close_btn");

modalBtn.addEventListener('click', open_delete_Modal);
ADD_MODAL_BTN.addEventListener('click',open_add_Modal);
closeBtn.addEventListener('click',closeModal)

function open_delete_Modal(){
    console.log('delete modal clicked');
    modal.style.display = 'flex';
}

function open_add_Modal(){
    console.log('ADD modal clicked');
    addmodal.style.display = 'flex';
}

function closeModal(){{
    console.log('close modal clicked');
     modal.style.display = 'none';
}}


