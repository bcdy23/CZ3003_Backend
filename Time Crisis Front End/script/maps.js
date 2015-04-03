// This example displays a marker at the center of Singapore.
// When the user clicks the marker, an info window opens.

function initialize() {
    var myLatlng = new google.maps.LatLng(1.337831, 103.832363);
    var myLatlng2 = new google.maps.LatLng(1.349641, 103.682941);
    var mapOptions = {
      zoom: 11,
      center: myLatlng
    };

var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

var contentString = '<div id="content">'+
    '<div id="siteNotice">'+
    '</div>'+
    '<h4 id="firstHeading" class="firstHeading">Fire Outbreak (Blk 236 Bishan St 81)</h4>'+
    '<div id="bodyContent">'+
    '<p>A fire outbreak at Blk 236 Bishan Street 81 #02-492 has occurred.</p>'+
    '<p><a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194" target="_blank">'+
    'More Details</a></p>'+
    '</div>'+
    '</div>';
    
var infowindow = null;

var marker = new google.maps.Marker({
    position: myLatlng,
    map: map,
    //Hover pop up description
    title: 'Fire Outbreak (Bishan)'
});

google.maps.event.addListener(marker, 'click', function() {
  
  if (infowindow) {
    infowindow.close();
  }
  
  infowindow = new google.maps.InfoWindow({
    content: contentString
  });
  
  infowindow.open(map, marker);
  
});

var contentString2 = '<div id="content">'+
  '<div id="siteNotice">'+
  '</div>'+
  '<h4 id="firstHeading" class="firstHeading">Road Accident (LWN Bus Stop)</h4>'+
  '<div id="bodyContent">'+
  '<p>A road accident at NTU LWN Bus Stop has occurred.</p>'+ 
  '<p><a href="#" target="_blank">'+
  'More Details</a></p>'+
  '</div>'+
  '</div>';

var marker2 = new google.maps.Marker({
    position: myLatlng2,
    map: map,
    //Hover pop up description
    title: 'Road Accident (NTU)'
});

google.maps.event.addListener(marker2, 'click', function() {
  
  if (infowindow) {
    infowindow.close();
  }
  
  infowindow = new google.maps.InfoWindow({
    content: contentString2
  });
  
  infowindow.open(map, marker2);
});

}

google.maps.event.addDomListener(window, 'load', initialize);