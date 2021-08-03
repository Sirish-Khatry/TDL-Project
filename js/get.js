(() => {
    let container = document.querySelector("#flex");

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
      // var head4 = document.createElement("h4");
      // head4.innerText = header[3];
      // var para4 = document.createElement("p");
      // para4.innerText = result[3];
      div.appendChild(head);
      div.appendChild(para);
      div.appendChild(head2);
      div.appendChild(para2);
      div.appendChild(head3);
      div.appendChild(para3);
      // div.appendChild(head4);
      // div.appendChild(para4);

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

})();