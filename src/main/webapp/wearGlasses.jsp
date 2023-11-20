<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="currentPage" value="Products" />
<c:set var="pageTitle" value="Products" />
<%@ include file="includes/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container">
    <h1>Wear glasses</h1>
    <br/>
    <p class="text-secondary">Trying on  : </p>
    <article class="wearGlasses-page">
        <div id="result" class="result">
            <img src="asset/images/df.png">
        </div>
        <form id="myForm" enctype="multipart/form-data">
            <div class="file">
                <input type="file" id="myFile" name="image">
                <span class="bg-info text-white"><i class="fas fa-file-upload"></i><br>Upload file</span>
            </div>
            <input type="hidden" id="myString" name="string" value="${glasses}"> <!-- Added hidden input field -->
            <button type="submit" class="uploadBttun" onclick="uploadImage(event)">
                <i class="fas fa-angle-double-right"></i><br>
                View result
            </button>
        </form>
    </article>
    
    <script>
        function uploadImage(event) {
            event.preventDefault(); // Prevent form submission

            var form = document.getElementById('myForm');
            var formData = new FormData(form);

            // Get the string and set it in the formData
            var myString = document.getElementById('myString').value;
            formData.set('string', myString);

            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'http://127.0.0.1:5000/process', true);

            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var response = JSON.parse(xhr.responseText);
                    displayImage(response.image_data);
                }
            };

            xhr.send(formData);
        }

        function displayImage(imageData) {
            var resultDiv = document.getElementById('result');
            img = resultDiv.querySelector('img');
            img.src = "data:image/jpeg;base64," + imageData;
          //  resultDiv.appendChild(img);
            saveImageData(imageData);
        }

        function saveImageData(imageData) {
             sessionStorage.setItem('processed_image_data', imageData);
        }

        // Retrieve and display the processed image data from local storage on page load
        document.addEventListener('DOMContentLoaded', function() {
            var storedData = sessionStorage.getItem('processed_image_data');
            if (storedData) {
                displayImage(storedData);
            }
        });
    </script>

</div>

<%@ include file="includes/footer.jsp" %>
