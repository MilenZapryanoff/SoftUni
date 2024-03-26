function solve(input) {

    class Song {
        constructor(type, name, time) {
            this.typelist = type;
            this.name = name;
            this.time = time;
        }
    }

    let songs = [];
    let songsCount = input.shift();
    let songType = input.pop();

    for (const songRecord of input) {
        let [type, name, time] = songRecord.split('_');
        let song = new Song(type, name, time);
        songs.push(song)
    }

    if (songType === 'all') {
        songs.forEach(song => console.log(song.name))
    } else {
        // let filtered = songs.filter(song => song.typelist === songType);
        // filtered.forEach(song => console.log(song.name))

        for (const song of songs) {
            if (song.typelist === songType) {
                console.log(song.name)
            }
        }
    }
}


solve([3,
    'favourite_DownTown_3:14',
    'favourite_Kiss_4:16',
    'favourite_Smooth Criminal_4:01',
    'favourite']
)

solve([4,
    'favourite_DownTown_3:14',
    'listenLater_Andalouse_3:24',
    'favourite_In To The Night_3:58',
    'favourite_Live It Up_3:48',
    'listenLater']
)
solve([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all']
)