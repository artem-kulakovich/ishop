try {
    const catalogBtn = document.getElementById("catalogBtn");
    catalogBtn.addEventListener("click", function (e) {
        let catalogDiv = document.getElementById("catalogDiv");
        let display = catalogDiv.style.display;
        if (display === "none") {
            catalogDiv.setAttribute("style", "display:block");
        } else {
            catalogDiv.setAttribute("style", "display:none");
        }
    });

} catch (e) {
}


try {
    infoBtn = document.querySelector("#infoAboutOrder");
    infoBtn.addEventListener("click", function (e) {
        let div = document.querySelector("#orderList");
        if (div.getAttribute("style") === "display:block") {
            div.setAttribute("style", "display:none");
        } else {
            div.setAttribute("style", "display:block");
        }
    });

} catch (e) {

}

try {
    let orderRefs = document.getElementsByName("orderRef");
    for (let orderRef of orderRefs) {
        let number = orderRef.getAttribute("data-value");
        orderRef.addEventListener("click", function (e) {
            e.preventDefault();
            let orderDiv = document.querySelector("#orderDiv" + number).getAttribute("style");
            if (orderDiv === "display:none") {
                document.querySelector("#orderDiv" + number).setAttribute("style", "display:block");
            } else {
                document.querySelector("#orderDiv" + number).setAttribute("style", "display:none");

            }
        });
    }
} catch (e) {

}

try {
    let feedBackBtn = document.querySelector("#feedBackBtn");
    feedBackBtn.addEventListener("click", function (e) {
        let type = document.getElementById("type");
        let msg = document.getElementById("msg");

        if (type.value < 5 || msg.value < 10) {
            alert("Проверьте введенные данные");
        }

    });
} catch (e) {

}


try {
    let messageLinks = document.getElementsByName("messageLink");
    for (let messageLink of messageLinks) {
        messageLink.addEventListener("click", function (e) {
            let messageId = messageLink.getAttribute("data-id");
            let messageDiv = document.querySelector("#messageDiv" + messageId);
            if (messageDiv.getAttribute("style") === "display:none") {
                messageDiv.setAttribute("style", "dis[lay:block");
            } else {
                messageDiv.setAttribute("style", "display:none");
            }

        });
    }
} catch (e) {

}

try {
    let sendReviewBtn = document.querySelector("#sendReviewBtn");
    sendReviewBtn.addEventListener("click", function (e) {

        let reviewLength = document.querySelector("#reviewText").value.length;
        console.log(reviewLength)
        if (reviewLength < 50 && reviewLength > 0) {
        } else {
            e.preventDefault();
            alert("Лимит на символы");
        }
    });
} catch (e) {

}



