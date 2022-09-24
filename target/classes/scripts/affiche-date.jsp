<script type="text/javascript">

var date = new Date();
//for getting today's date
var today = date.getFullYear().toString() + '-' + (date.getMonth() + 1).toString().padStart(2, 0) +
'-' + date.getDate().toString().padStart(2, 0);

var inputDate = document.getElementById("inputDate");


inputDate.value = today;


</script>