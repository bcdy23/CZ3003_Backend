// This example displays a marker at the center of Singapore.
// When the user clicks the marker, an info window opens.

function closeInfoWindow(infowindow) {
    if (infowindow) {
        infowindow.close();
    }
}

function initialize() {
    var myLatlng = new google.maps.LatLng(1.337831, 103.832363);
    var myLatlng2 = new google.maps.LatLng(1.349641, 103.682941);
    var myLatlng3 = new google.maps.LatLng(1.349641, 103.752941);
    var mapOptions = {
      zoom: 11,
      center: myLatlng
    };

    var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    var infowindow = null;
    
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
    
    var marker = new google.maps.Marker({
        position: myLatlng,
        map: map,
        icon: 'http://labs.google.com/ridefinder/images/mm_20_red.png',
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
        icon: 'http://labs.google.com/ridefinder/images/mm_20_blue.png',
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
    
    var contentString3 = '<div id="content">'+
      '<div id="siteNotice">'+
      '</div>'+
      '<h4 id="firstHeading" class="firstHeading">Dengue Affected Area</h4>'+
      '<div id="bodyContent">'+
      '<p>No. of people affected: 17</p>'
      '</div>'+
      '</div>';
    
    var myCity = new google.maps.Circle({
        center:myLatlng3,
        radius:800,
        strokeColor:"#114455",
        strokeOpacity:0.8,
        strokeWeight:2,
        fillColor:"#14ad80",
        fillOpacity:0.4,
        map: map
    });
    
    google.maps.event.addListener(myCity, 'click', function() {
        closeInfoWindow(infowindow);
        
        infowindow = new google.maps.InfoWindow({
            content: contentString3,
            position: myLatlng3
        });
        
        infowindow.open(map);
    });
}

google.maps.event.addDomListener(window, 'load', initialize);