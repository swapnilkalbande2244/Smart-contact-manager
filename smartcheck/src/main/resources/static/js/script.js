// const toggleSidebar = () => {
//     if ($(".sidebar").is(":visible")) {
//         $(".sidebar").css("display","none")
//         $(".content").css("margin-left","0%")
//     } else {
//         $(".sidebar").css("display","block")
//         $(".content").css("margin-left","20%")
//     }
// }

function w3_open() {
    document.getElementById("content").style.marginLeft = "20%";
    // document.getElementById("mySidebar").style.width = "25%";
    document.getElementById("sidebar").style.display = "block";
    // document.getElementById("openNav").style.display = 'none';
  }

  function w3_close() {
    document.getElementById("content").style.marginLeft = "0%";
    document.getElementById("sidebar").style.display = "none";
    // document.getElementById("openNav").style.display = "inline-block";
  }