 //**************  FORM HEADER SELECT LOGIN/SINGUP FORM *****************
      $("#loginfornlink").click(function () {
        
         $(this).addClass('formActiveBorder'); 
         $("#signupforlinkm").removeClass('formActiveBorder'); 
         $("#signupform").hide();
         $("#loginforn").fadeIn(500);
      });
      $("#signupforlinkm").click(function () {
        
         $(this).addClass('formActiveBorder'); 
         $("#loginfornlink").removeClass('formActiveBorder');
         $("#loginforn").hide();
         $("#signupform").fadeIn(500);
      });

    //************ signup html view  ***********
      $("#next").click(function () {
        $(".secondview").hide();
        $(".firstview").show(300);
        $(this).hide();
        $("#previous").show();
        $("#submit").show();
      });
      $("#previous").click(function () {
        $(".firstview").hide();
        $(".secondview").show(300);
        $(this).hide();
        $("#next").show();
        $("#submit").hide();
      });
        $(".close").click(function () {
            $(".error").hide(200);
        });



$(document).ready(function(){

  $image_crop = $('#image_demo').croppie({
    enableExif: true,
    viewport: {
      width:200,
      height:200,
      type:'square' //circle
    },
    boundary:{
      width:300,
      height:300
    }
  });

  $('#upload_image').on('change', function(){
    var reader = new FileReader();
    reader.onload = function (event) {
      $image_crop.croppie('bind', {
        url: event.target.result
      }).then(function(){
        console.log('jQuery bind complete');
      });
    }
    reader.readAsDataURL(this.files[0]);
    $('#uploadimageModal').modal('show');
  });

  $('.crop_image').click(function(event){
    $image_crop.croppie('result', {
      type: 'canvas',
      size: 'viewport'
    }).then(function(response){
      $.ajax({
        url:"upload.php",
        type: "POST",
        data:{"image": response},
        success:function(data)
        {
          $('#uploadimageModal').modal('hide');
          $('#uploaded_image').html(data);
        }
      });
    })
  });

});