<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css"
  rel="stylesheet"
/>
<%@ include file = "css/style.jsp"%>
<title>Meeting Room Reservation</title>
</head>
<body>
<header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
<!--Main Navigation-->

<!--Main layout-->
<main style="margin-top: 58px">
  <div class="container pt-4">
<!-- Heading -->
<mdb-card class="mb-4 wow fadeIn">

    <!--Card content-->
    <mdb-card-body class="d-sm-flex justify-content-between">

        <h4 class="mb-sm-0 pt-3">
            <a href="/" target="_blank">Home</a>
            <span>/</span>
            <span>Dashboard</span>
        </h4>

        <form class="d-flex md-form justify-content-center my-0">
            <!-- Default input -->
            <input type="search" placeholder="Type your query" aria-label="Search" class="form-control" mdbInput>
            <button mdbBtn color="primary" size="sm" class="my-0 p" type="submit">
                <mdb-icon fas icon="search"></mdb-icon>
            </button>

        </form>

    </mdb-card-body>

</mdb-card>
<!-- Heading -->

<div class="row mt-3">
    <div class="col-md-12">
        <!--Card-->
        <mdb-card cascade="true" narrower="true" class="mt-1">
            <!--Card image-->
            <div class="view gradient-card-header blue darken-2">
                <h4 class="h4-responsive " aria-describedby="tip">Booking Information </h4>
                <small id="tip" class="mb-4 ">
                    Latest booking will appear first
                </small>
            </div>
            <!--/Card image-->
            <!--Card content-->
            <mdb-card-body>

                <!-- Table -->
                <div class="table-responsive">
                    <table mdbTable small="true" hover="true">
                        <!-- Table head -->
                        <thead class="blue lighten-4">
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Capacity</th>
                                <th>Start Time</th>
                                <th>End Time</th>
                                <th>Purpose</th>
                                <th>Booked By</th>
                            </tr>
                        </thead>
                        <!-- Table head -->

                        <!-- Table body -->
                        <tbody>
                            <tr>
                                <th scope="row"> </th>
                                <td> </td>
                                <td> </td>
                                <td></td>
                                <td> </td>
                                <td> </td>
                            </tr>
                        </tbody>
                        <!-- Table body -->
                    </table>
                </div>
                <!-- Table  -->

            </mdb-card-body>
            <!--/.Card content-->
        </mdb-card>
        <!--/.Card-->
    </div>
</div>

  </div>
</main>
<!--Main layout-->
    <!--Container Main end-->
    <!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>

</html>
