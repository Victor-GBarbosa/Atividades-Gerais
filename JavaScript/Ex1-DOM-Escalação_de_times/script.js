function escalar() {
  let name = document.getElementById("inputName").value;
  let pos = document.getElementById("inputPos").value;
  let number = document.getElementById("inputNumber").value;

  let newPlayer = document.createElement("li");
  newPlayer.innerText = pos + ": " + name + " (" + number + ")";
  newPlayer.id = "player-" + number;

  document.getElementById("playersList").appendChild(newPlayer);

  console.log(name, pos, number);
}

function removePlayer() {
  let removeInput = document.getElementById("playerToRemove").value;
  console.log(removeInput);
  document.getElementById("player-" + removeInput).remove();
}
