import styles from "./Button.module.css";

export default function Button({ btnText }) {
  return (
    <>
      <button className={styles.style}>{btnText}</button>
    </>
  );
}
