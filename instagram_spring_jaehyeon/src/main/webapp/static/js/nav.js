const profileImg = document.querySelector(".profile-img");
const bLogo = document.querySelector(".b-logo");

load();

function load(){
	profileImg.src = getProfileImg();
}

bLogo.onclick = () => {
	location.href = "/jaehyeon/";
}

profileImg.onclick = () => {
	location.href = "/jaehyeon/account/profile";
}
