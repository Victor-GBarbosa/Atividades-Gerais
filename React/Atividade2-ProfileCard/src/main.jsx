import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import Card from "./components/Card/Card";
import image from "./assets/image.jpg";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <Card
      btnText1={"GitHub"}
      btnText2={"Instagram"}
      btnText3={"Linkedin"}
      name={"Nome Sobrenome"}
      imgAlt={"image"}
      imgUrl={image}
      text1={"Fullstack developer"}
      text2={"+55619961811234"}
      text3={"email@gmail.com"}
    ></Card>
  </StrictMode>
);
