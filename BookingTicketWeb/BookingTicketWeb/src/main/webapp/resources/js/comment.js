/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global trip, fetch */
//function loadComments() {
//     fetch("/BookingTicketWeb/comment").then(function (res) {
//        return res.json();
//    }).then(function (data) {
//        let area = document.getElementById("commentArea");
//        let h = '';
//        for (let d of data)
//            h += `
//                <div class="col-md-4 col-xs-12" style="padding:10px;">
//                     <div class="card-body ">
//                         <p>Nội dung: ${d.content}</li>
//                         <p class="comment-date">${moment(d.createddate).fromNow()} </p>
//                         <hr>                   
//                     </div>
//
//                 </div>
//            `;
//        area.innerHTML = h;
//    });
//}

function addComment(event, tripId) {
    event.preventDefault();
    console.log('trigger on submit', event, tripId);
    fetch("/BookingTicketWeb/comment", {
        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("commentId").value,
            "trip": tripId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => {
        return res.json();
    }).then(data => {
        console.log(data);


        let area = document.getElementById("commentArea");

        area.innerHTML = `
        
        <div class="be-comment">
            <div class="be-img-comment">	
                    <a href="blog-detail-2.html">
                        <img  src="${data.customerId.avatar}" class="rounded-circle be-ava-comment" />				
                    </a>
                </div>
                <div class="be-comment-content">

                    <span class="be-comment-name">
                        <a href="blog-detail-2.html">${data.customerId.name}</a>
                    </span>
                    <span class="be-comment-time comment-date">
                         <i class="fa-solid fa-clock"></i>
                         ${moment(data.createddate).fromNow()}
                    </span>

                    <p class="be-comment-text">
                        ${data.content}
                    </p>
                </div>
        </div>
       
        ` + area.innerHTML;
        let reset = document.getElementById("commentId");
        reset.value = null;


    });
}

let mybutton = document.getElementById("myBtn");

window.onscroll = function() {scrollFunction();};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

function topFunction() {
  document.documentElement.scrollTop = 0;
}

