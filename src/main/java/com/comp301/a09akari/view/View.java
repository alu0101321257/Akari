package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.ClassicMvcController;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
/**
 * The View class is responsible for rendering the user interface components for the Akari Puzzle game.
 * It uses other components such as MessageView, PuzzleView, and ControlView to display the puzzle board,
 * messages, and control buttons.
 */
public class View implements FXComponent {
  private ClassicMvcController controller;
  private Model model;
  /**
   * Constructs a View instance with the specified controller and model.
   *
   * @param ac The ClassicMvcController instance for handling user interactions.
   * @param m  The Model instance representing the game state and logic.
   */
  public View(ClassicMvcController ac, Model m) {
    this.controller = ac;
    this.model = m;
  }
  /**
   * Renders the main user interface components of the Akari Puzzle game.
   *
   * @return A Parent node containing the rendered UI components.
   */
  public Parent render() {
    BorderPane format = new BorderPane();
    FXComponent messageView = new MessageView(controller, model);
    FXComponent puzzleView = new PuzzleView(controller, model);
    FXComponent controlView = new ControlView(controller, model);

    format.setCenter(puzzleView.render());
    format.setLeft(messageView.render());
    format.setRight(controlView.render());

    return format;
  }
}
