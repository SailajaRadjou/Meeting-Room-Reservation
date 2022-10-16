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
<%@ include file = "css/home-style.jsp"%>
<title>Meeting Room Reservation</title>
</head>
<body>
<div class="container p-5 my-5">

 <header>
  <!-- Sidebar -->
  <%@ include file = "layout/side-bar.jsp" %>
</header>
    <div class="container my-5">

	
  <!--Section: Content-->
  <section class="text-center dark-grey-text mb-5">

    <div class="card">
      <div class="card-body rounded-top border-top p-5">
        
        <!-- Section heading -->
        <h3 class="font-weight-bold my-4">Contact Us</h3>
        <!-- Section description -->
        <p class="font-weight-light mx-auto mb-4 pb-2">We love to hear from you!</p>

        <form class="mb-4 mx-md-5" action="">

          <div class="row">
            <div class="col-md-6 mb-4">

              <!-- Name -->
              <input type="text" id="name" class="form-control" placeholder="Name">

            </div>
            <div class="col-md-6 mb-4">

              <!-- Email -->
              <input type="email" id="email" class="form-control" placeholder="Email">

            </div>
          </div>

          <div class="row">
            <div class="col-md-12 mb-4">

              <!-- Subject -->
              <input type="text" id="subject" class="form-control" placeholder="Subject">

            </div>
          </div>

          <div class="row">
            <div class="col-md-12">

              <div class="form-group mb-4">
                <textarea class="form-control rounded" id="message" rows="3" placeholder="How can we help?"></textarea>
              </div>

              <div class="text-center">
                <button type="submit" class="btn btn-info btn-md">Submit</button>
              </div>

            </div>
          </div>

        </form>
        
      </div>
    </div>

  </section>
  <!--Section: Content-->

</div>
  </div>
  <script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"
></script>
</body>

</html>