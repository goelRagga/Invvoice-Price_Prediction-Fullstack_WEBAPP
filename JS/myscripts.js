
 var invoiceid;
const resetall = () => {
    console.log("Reset Function Called");
    document.getElementById("Customer_name").value="";
    document.getElementById("Customer_No").value="";
    document.getElementById("Customer_Invoice").value="";
    document.getElementById("Invoice_amount").value="";
    document.getElementById("Due_Date").value="";
    document.getElementById("Notes").value="";
}



const showTableData = (result_data) =>{

    console.log("Table Data");
    console.log(result_data.length)
    var table=document.getElementById('final_table');
     result_data.forEach(object =>{
        var tr=document.createElement("tr");
        tr.innerHTML = `<td><input type="checkbox" id=${object.invoice_iD}  class="checkbox" onclick="storing(this)" >${object.Customer_name}</td>
                        <td>${object.Customer_ID}</td>
                        <td>${object.invoice_iD}</td>
                        <td>${object.Amount}</td>
                        <td>${object.due_date}</td>
                        <td>${object.Clear_date}</td>
                        <td>${object.Notes}</td>
                        `;
        table.appendChild(tr);
     });

}


// Searching 

const Searching = () => {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("my_Input");
  filter = input.value;
  table = document.getElementById("final_table");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[2];
    if (td) {
        console.log(td);
      txtValue = td.textContent || td.innerText;
      if (txtValue==filter) {
        tr[i].style.display = "";
        
      } else {
        tr[i].style.display = "none";
        
     
      }
    }
  }
}

const fetchData = () =>{
    fetch('http://localhost:8080/H2HBABBA2277/dummy.do')
    .then(response =>{
        console.log("Read Succesfully");
        return response.json();
    }).then(Json_result=>{
        showTableData(Json_result);
    })
    .catch(error=>{
        console.log(error);
    })
}

(
    function(){
        fetchData()
    }
)()



const submit = () =>{
  console.log("Welcome to add modal ");
  const name=document.getElementById('Customer_name').value;
  const number=document.getElementById('Customer_No').value;
  const Invoice=document.getElementById('Customer_Invoice').value;
  const amount=document.getElementById('Invoice_amount').value;
  const duedate=document.getElementById('Due_Date').value;
  const notes=document.getElementById('Notes').value;
  

  console.log(`Name : ${name}`);
  console.log(`Number : ${number}`);
  console.log(`Invoice ID : ${Invoice}`);
  console.log(`Total amount : ${amount}`);
  console.log(`Due-Date : ${duedate}`);
  console.log(`Notes : ${notes}`);
 
  fetch(`http://localhost:8080/H2HBABBA2277/Add?name=${name}&number=${number}&Invoice=${Invoice}&amount=${amount}&duedate=${duedate}&notes=${notes}`,
{
    method: 'POST',
 } ).then(()=>{
      window.location.reload();
 })
};


const storing =(e)=>{
  invoiceid=e.getAttribute('id');
  
}

const deleting =() =>{
    fetch(`http://localhost:8080/H2HBABBA2277/Delete?invoiceid=${invoiceid}`,
  {
    method: "POST",
  }).then((res)=>{
    console.log("Deleted!");
    window.location.reload();
  });
 

}

const reset_edit = () =>{

  document.getElementById('Invoice_amount_edit').value='';
  document.getElementById('NOTES_edit').value='';

}

const editing = () =>{

  const amount=document.getElementById('Invoice_amount_edit').value;
  const notes=document.getElementById('NOTES_edit').value;
  console.log(amount);
  console.log(notes);

     fetch(`http://localhost:8080/H2HBABBA2277/Edit?invoiceid=${invoiceid}&amount=${amount}&notes=${notes}`,
  {
    method: "POST",
  }).then((res)=>{
    console.log("Editted!");
    window.location.reload();
  });
}



  
