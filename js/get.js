(() => {


    let container = document.querySelector("#flex");
    let openCreateBtn = document.querySelector("#createBtn");
    let openUpdateBtn = document.querySelector("#updateBtn");
    let openDeleteBtn = document.querySelector("#deleteBtn");
    let submitCreateBtn = document.querySelector("#createSubmit");
    let submitUpdateBtn = document.querySelector("#updateSubmit");
    let submitDeleteBtn = document.querySelector("#deleteSubmit");
    let task = document.querySelector("#task");
    let itemID = document.querySelector("#itemID");
    let status = document.querySelector("#status");
    let itemIDdel = document.querySelector("#itemIDdel");
    let task_update = document.querySelector("#task-update");
    let status_update = document.querySelector("#status-update");

  function createCard(header, result){

      var div = document.createElement("div");
      div.setAttribute("class", "card");
      var head = document.createElement("h4");
      head.innerText = header[0];
      var para = document.createElement("p");
      para.innerText = result[0];
      var head2 = document.createElement("h4");
      head2.innerText = header[1];
      var para2 = document.createElement("p");
      para2.innerText = result[1];
      var head3 = document.createElement("h4");
      head3.innerText = header[2];
      var para3 = document.createElement("p");
      para3.innerText = result[2];

      div.appendChild(head);
      div.appendChild(para);
      div.appendChild(head2);
      div.appendChild(para2);
      div.appendChild(head3);
      div.appendChild(para3);


    return div;
  }
    function simpleFetch(){
      const a = ["http://127.0.0.1:80/item"];
          fetch(a)
          .then((response => {
            if(response.status !== 200){
              console.error(`status: ${response.status})`);
              return;
            }
            return response.json();
          })) 
          .then(data => {
              const result = data.map(({id, task, status}) => [id, task, status]);
              for (data of result) {
              const table = createCard(header, data);
              container.appendChild(table);
              }
          })
          .catch(error => console.error(error))
          .finally(() => { console.log("All OK!"); });

      }
  const header = ["ID", "TASK", "STATUS"];
  simpleFetch();

  openCreateBtn.addEventListener("click", (event) => {
    document.getElementById("createForm").style.display = "block";
  }, false);
  

  submitCreateBtn.addEventListener("click", (event) => {
    const data = {task: task.value, status: status.value};

    console.log(data);

    document.getElementById("createForm").style.display = "none";
  }, false);

  openUpdateBtn.addEventListener("click", (event) => {
    document.getElementById("updateForm").style.display = "block";
  }, false);

  submitUpdateBtn.addEventListener("click", (event) => {
    const data = {id: itemID.value, task: task_update.value, status: status_update.value};

    console.log(data);

    document.getElementById("updateForm").style.display = "none";
  }, false);

  openDeleteBtn.addEventListener("click", (event) => {
    document.getElementById("deleteForm").style.display = "block";
  }, false);

  submitDeleteBtn.addEventListener("click", (event) => {
    const data = {id: itemIDdel.value};

    console.log(data); 

    document.getElementById("deleteForm").style.display = "none";
  }, false);

})();