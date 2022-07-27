var audioPlayer = document.getElementById('audio-player');
var btnPlay = document.getElementById('btnPlay');
var btnPause = document.getElementById('btnPause');
var loaded = false;

btnPause.addEventListener('click', (e) => {

    e.preventDefault();
    audioPlayer.pause();
    btnPlay.style.display = "inline";
    btnPause.style.display = "none";

    return false;
});

btnPlay.addEventListener('click', (e) => {

    e.preventDefault();
    play();

    return false;
});

function play() {

    audioPlayer.play();
    btnPlay.style.display = "none";
    btnPause.style.display = "inline";
}

const playSong = (file) => {

    if (loaded == false) {

        audioPlayer.innerHTML = `<source src="` + file + `" type="audio/mp3">`;
        loaded = true;
    }
    play();
}

document.querySelectorAll('.main-col').forEach(item => {

    item.addEventListener('click', event => {

        let image = item.getAttribute('data-image');
        let artist = item.getAttribute('data-artist');
        let song = item.getAttribute('data-song');
        let file = item.getAttribute('data-file');
        let playerArtistComponent = document.getElementsByClassName('player-artist');

        playerArtistComponent[0].innerHTML = `

            <img src="` + image + `"/>
            <h3>` + song + `<br/><span>` + artist + `<span><h3>
        `;

        playSong(file);
    })
});