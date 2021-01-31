let stompClient = null;

function connect() {
  let socket = new SockJS('/job-socket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
    // console.log('Connected: ' + frame);
    stompClient.subscribe('/job/updates', function (data) {
      let job = JSON.parse(data.body);
      let url = job.url;
      let id = job.id;
      let status = job.status;
      let httpCode = job.httpCode;
      let completedBy = job.completedBy;
      
      let rowId = document.getElementById(id + "id");
      let rowUrl = document.getElementById(id + "url");
      let rowStatus = document.getElementById(id + "status");
      let rowHttpCode = document.getElementById(id + "httpCode");
      
      rowId.innerHTML = id;
      rowUrl.innerHTML = url;
      rowStatus.innerHTML = status;
      rowHttpCode.innerHTML = httpCode;
      setStatusTextColor(rowStatus, status);
      updateCompletionStats(completedBy);
      
    });
  });
}

const updateCompletionStats = (completer) => {
  switch (completer) {
    case "process1":
      let proc1 = document.getElementById("proc1");
      proc1.innerHTML = (parseInt(proc1.innerHTML) + 1).toString();
      break;
    case "process2":
      let proc2 = document.getElementById("proc2");
      proc2.innerHTML = (parseInt(proc2.innerHTML) + 1).toString();
      break;
    case "process3":
      let proc3 = document.getElementById("proc3");
      proc3.innerHTML = (parseInt(proc3.innerHTML) + 1).toString();
      break;
  }
}


const setStatusTextColor = (elem, status) => {
  switch (status) {
    case "NEW":
    default:
      elem.style.color = "blue";
      break;
    case "PROCESSING":
      elem.style.color = "orange";
      break;
    case "DONE":
      elem.style.color = "green";
      break;
    case "ERROR":
      elem.style.color = "red";
      break;
    
  }
}

connect();
const processJob = (processor_name) => {
  function beginProcessing() {
    stompClient.send("/start/job", {}, processor_name);
  }
  setTimeout(beginProcessing, 1000);
}




