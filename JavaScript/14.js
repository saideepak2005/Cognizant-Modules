$(document).ready(function() {
  let isVisible = true;
  
  $("#registerBtn").click(function() {
    if (isVisible) {
      $(".card").fadeOut();
      $(this).text("Show Events");
    } else {
      $(".card").fadeIn();
      $(this).text("Toggle Events View");
    }
    isVisible = !isVisible;
  });
});
