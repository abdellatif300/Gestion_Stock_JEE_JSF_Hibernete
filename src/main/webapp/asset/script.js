// ---------Responsive-navbar-active-animation-----------
$(".navbar-toggler").click(function(){
	$(".navbar-collapse").slideToggle(300);
});
$(document).ready(()=>{
	AOS.init();

})

/************************
 *  SEARCH BAR & CATEGORY
 ***********************/
function getCategoryValue() {
	let categoryValue = $("#myCategory").val()?.toLowerCase();

	$(".filterOptions .list-buttons").children().each(function() {
		$(this).removeClass("active");
	});

	if (categoryValue == "sunglasses") {
		$("#sunglassesCategory").addClass("active");
		return categoryValue;
	}
	if(categoryValue == "eyeglasses"){
		$("#eyeglassesCategory").addClass("active")
		return categoryValue;
	}
	$("#allCategories").addClass("active")
	return null;
}

const filterArticles = (titleToFind) => {
	let category = getCategoryValue();
	let count = 0;
	$("article").filter(function () {
		/* CATEGORY */
		let foundCategory = true;
		if (category) {
			let tmpCategory = $(this)
				.children(".desc")
				.children(".bottom-desc")
				.children(".category")
				.text();
			foundCategory = tmpCategory.toLowerCase().indexOf(category) > -1;
		}

		/* SEARCHING */
		let tmpTitle = $(this).children(".desc").children("h3").text();
		let foundTitle = tmpTitle.toLowerCase().indexOf(titleToFind) > -1;

		$(this).toggle(foundCategory && foundTitle);
		if (foundCategory && foundTitle) {
			count++;
		}
	});
	if (!count) {
		$("#NotFound").show();
	} else {
		$("#NotFound").hide();
	}
	AOS.init();
};

$(document).ready(function () {
	/* SEARCHING */
	$("#myInput").on("keyup", function () {
		let value = $(this).val();
		if(value){
			filterArticles(value.toLowerCase());

		}
	});

	/* CATEGORY */
	let category = getCategoryValue();
	if (category) {
		filterArticles("");
	}




	/************************
	 *  Filter
	 ***********************/

	$("#allCategories").on("click", function () {
		console.log("clicked1")
		$("#myCategory").val("")
		let value = $("#myInput").val();
		if(value){
			filterArticles(value.toLowerCase());
		}else{
			filterArticles("");
		}
	});
	$("#sunglassesCategory").on("click", function () {
		console.log("clicked2")
		$("#myCategory").val("sunglasses")
		let value = $("#myInput").val();
		if(value){
			filterArticles(value.toLowerCase());
		}else{
			filterArticles("");
		}
	});
	$("#eyeglassesCategory").on("click", function () {
		console.log("clicked3")
		$("#myCategory").val("eyeglasses")
		let value = $("#myInput").val();
		if(value){
			filterArticles(value.toLowerCase());
		}else{
			filterArticles("");
		}
	});




});
