import Button from "../Button/Index";
import styles from "./Card.module.css";

export default function Card() {
  return (
    <div className={styles.card}>
      <img
        src="/image.jpg"
        alt="coisa"
        style={{
          width: "200px",
          height: "auto",
        }}
      />
      <div className={styles.content}>
        <h2>Pôster: Star Wars</h2>
        <p>
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit
          molestias molestiae, deserunt, ut magni unde exercitationem quia
          doloremque laboriosam tenetur neque nobis animi.
        </p>
        <Button />
      </div>
    </div>
  );
}
