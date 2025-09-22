import styles from "./Card.module.css";
import Button from "../Button/Button";

function Card({
  name,
  imgUrl,
  imgAlt,
  text1,
  text2,
  text3,
  btnText1,
  btnText2,
  btnText3,
}) {
  return (
    <div className={styles.container}>
      <img src={imgUrl} alt={imgAlt} />
      <h2>{name}</h2>
      <p>{text1}</p>
      <p>{text2}</p>
      <p>{text3}</p>
      <Button btnText={btnText1}></Button>
      <Button btnText={btnText2}></Button>
      <Button btnText={btnText3}></Button>
    </div>
  );
}

export default Card;
